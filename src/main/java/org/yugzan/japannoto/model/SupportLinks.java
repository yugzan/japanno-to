package org.yugzan.japannoto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.yugzan.japannoto.model.Link.REL;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author  yugzan
 * @date    2015年9月21日
 * @project japanno-to
 */
public abstract class SupportLinks {

	
	protected Collection<Link> links = new ArrayList<>();
	
	protected String getSelfLink(HttpServletRequest request){
		Optional<String> option = Optional.ofNullable(request.getQueryString());
		String query = (option.isPresent())? "?" +option.get():"";
		return request.getRequestURL().toString() + query;
	}
	
	protected void sort(){
		Collections.sort((List<Link>) this.links);
	}
	
	/**
	 * If resource Links not have a rel of self, will automatically insert link.
	 * */
	protected void checkSelf(String url){
		Link link = new Link(REL.self,url);
		if(!this.links.contains(link)){
			this.links.add(link);
		}
		sort();
	}
	/**
	 * If resource Links not have a rel of self, will automatically insert link.
	 * */
	protected void checkSelf(HttpServletRequest request){
		Link link = new Link(REL.self,getSelfLink(request));
		if(!this.links.contains(link)){
			this.links.add(link);
		}
		sort();
	}
	
	@JsonProperty("_links")
	protected List<Link> getLinks() {
		return (List<Link>) links;
	}
	
	protected void setLinks(Collection<Link> links) {
		this.links = Objects.requireNonNull(links, "links is null");
	}

	@Override
	public String toString() {
		return "Links [links=" + links + "]";
	}
}


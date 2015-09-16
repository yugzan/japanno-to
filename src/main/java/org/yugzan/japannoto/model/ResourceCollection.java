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
 * @author yugzan
 * @param <I>
 * @date 2015年9月17日
 * @project japanno-to
 */
public class ResourceCollection<I> {
	
	private Collection<I> resources = new ArrayList<>();
	
	private Collection<Link> links = new ArrayList<>();


	public ResourceCollection(Collection<I> resources) {
		this.resources = Objects.requireNonNull(resources, "resources is null");
		
		this.links.add( new Link(REL.self,"") );
	}
	
	@SuppressWarnings("unchecked")
	public ResourceCollection(Collection<I> resources, Collection<? extends Link> links) {
		this.resources = Objects.requireNonNull(resources, "resources is null");
		this.links = (Collection<Link>) Objects.requireNonNull(links, "links is null");
		Link link = new Link(REL.self,"");
		if(!this.links.contains(link)){
			this.links.add(link);
		}
		Collections.sort((List<Link>) this.links);
	}
	
	public ResourceCollection(Collection<I> resources,HttpServletRequest request) {
		this.resources = Objects.requireNonNull(resources, "resources is null");
		
		this.links.add( new Link(REL.self,getSelfLink(request) ));
	}
	
	@SuppressWarnings("unchecked")
	public ResourceCollection(Collection<I> resources, Collection<? extends Link> links,HttpServletRequest request) {
		this.resources = Objects.requireNonNull(resources, "resources is null");
		this.links = (Collection<Link>) Objects.requireNonNull(links, "links is null");
		
		Link link = new Link(REL.self,getSelfLink(request));
		if(!this.links.contains(link)){
			this.links.add(link);
		}
		Collections.sort((List<Link>) this.links);
	}
	

	public Collection<I> getResources() {
		return resources;
	}

	public void setResources(Collection<I> resources) {
		this.resources = resources;
	}
	
	@JsonProperty("_links")
	public Collection<? extends Link> getLinks() {
		return links;
	}
	
	public void setLinks(Collection<Link> links) {
		this.links = links;
	}
	
	@Override
	public String toString() {
		return "ResourceCollection [resources=" + resources + "]";
	}
	
	private String getSelfLink(HttpServletRequest request){
		Optional<String> option = Optional.ofNullable(request.getQueryString());
		String query = (option.isPresent())? "?" +option.get():"";
		return request.getRequestURL().toString() + query;
	}
	
}

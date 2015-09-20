package org.yugzan.japannoto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yugzan
 * @param <I>
 * @date 2015年9月17日
 * @project japanno-to
 */
public class ResourceCollection<I> extends SupportLinks{
	
	private Collection<I> resources = new ArrayList<>();
	
	
	public ResourceCollection(Collection<I> resources) {
		this(resources, new ArrayList<Link>() );

	}
	
	@SuppressWarnings("unchecked")
	public ResourceCollection(Collection<I> resources, Collection<? extends Link> links) {
		this.resources = Objects.requireNonNull(resources, "resources is null");
		setLinks((Collection<Link>)links);
		checkSelf("");
	}
	
	
	public ResourceCollection(Collection<I> resources,HttpServletRequest request) {
		this(resources, new ArrayList<Link>(), request);
		
	}
	
	@SuppressWarnings("unchecked")
	public ResourceCollection(Collection<I> resources, Collection<? extends Link> links,HttpServletRequest request) {
		
		this.resources = Objects.requireNonNull(resources, "resources is null");
		
		setLinks((Collection<Link>)links);
		checkSelf(request);
	}
	

	public Collection<I> getResources() {
		return resources;
	}

	public void setResources(Collection<I> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "ResourceCollection [resources=" + resources + ", links=" + links + "]";
	}
	

	

	
}

package org.yugzan.japannoto.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

/**
 * @author  yugzan
 * @date    2015年9月21日
 * @project japanno-to
 */
public class Resource<I> extends SupportLinks{
	
	private I item;

	/**
	 * @param item
	 */
	public Resource(I item) {
		this(item, new ArrayList<Link>());
		
	}
	/**
	 * @param item
	 * @param request
	 */
	public Resource(I item,HttpServletRequest request) {
		this(item, new ArrayList<Link>(),request);
	}
	
	/**
	 * @param item
	 * @param links
	 */
	@SuppressWarnings("unchecked")
	public Resource(I item, Collection<? extends Link> links) {
		super();
		this.item = item;
		setLinks((Collection<Link>) links);
		checkSelf("");
	}
	/**
	 * @param item
	 * @param links
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	public Resource(I item, Collection<? extends Link> links,HttpServletRequest request) {
		super();
		this.item = item;
		setLinks((Collection<Link>) links);
		checkSelf(request);
	}
	
	public I getItem() {
		return item;
	}

	public void setItem(I item) {
		this.item = item;
	}
	
	@Override
	public String toString() {
		return "Resource [item=" + item + ", links=" + links + "]";
	}
	
	
}



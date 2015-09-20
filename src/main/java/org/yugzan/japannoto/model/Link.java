package org.yugzan.japannoto.model;

import java.util.Objects;

/**
 * @author yugzan
 * @date 2015年9月17日
 * @project japanno-to
 */
public class Link implements Comparable<Link> {
	public enum REL {
		self, edit, item, collection, related, search, first, last, previous, next
	}

	protected REL rel;

	protected String href;

	public Link() {

	}

	/**
	 * @param rel
	 * @param href
	 */
	public Link(REL rel, String href) {
		super();
		this.rel = rel;
		this.href = href;
	}

	public REL getRel() {
		return rel;
	}

	public Link setRel(REL rel) {
		this.rel = rel;
		return this;
	}

	public String getHref() {
		return href;
	}

	public Link setHref(String href) {
		this.href = href;
		return this;
	}

	@Override
	public String toString() {
		return "Link [rel=" + rel + ", href=" + href + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Link o) {
		return 
			(this.rel.ordinal() > o.rel.ordinal())?1:
			(this.rel.ordinal() < o.rel.ordinal())?-1:0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.rel);
	}

	@Override
	public boolean equals(Object that) {
        if(that instanceof Link) {
        	Link l = (Link) that;
            return this.rel == l.rel;
        }
        return false;
	}

}

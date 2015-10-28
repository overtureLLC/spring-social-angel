package org.springframework.social.angel.api.impl.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ryo on 10/28/15.
 */
public class PagedList<T> extends ArrayList<T> {
    private final long total;
    private final long perPage;
    private final long page;
    private final long lastPage;

    public PagedList(Collection<? extends T> collection, long total, long perPage,long page,long lastPage){
        super(collection);
        this.total=total;
        this.perPage=perPage;
        this.page = page;
        this.lastPage=lastPage;
    }

    public long getTotal() {
        return total;
    }

    public long getLastPage() {
        return lastPage;
    }

    public long getPage() {
        return page;
    }

    public long getPerPage() {
        return perPage;
    }


}

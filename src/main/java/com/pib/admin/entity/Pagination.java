package com.pib.admin.entity;

import java.io.Serializable; 
import com.pib.admin.model.builder.AbstractBuilder;
import com.pib.admin.nullhandler.NotNullObject;
import com.pib.admin.nullhandler.NullObject;
 

public class Pagination implements Serializable, NotNullObject {
    private Long id;
    private Integer fristPage;
    private Integer currentPage;
    private Integer rangeMin;
    private Integer rangeMax;
    private Integer lastPage;
    
     
    public static final Null NULL = new Null();

    private static class Null extends Pagination implements NullObject {
    }

    public static class Builder extends AbstractBuilder {
        @Override
        public Pagination build() {
            try {
                return super.build(Pagination.class);
            } catch (InstantiationException | IllegalAccessException e) {
                return NULL;
            }
        }
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 
	public Integer getFristPage() {
		return fristPage;
	}

	public void setFristPage(Integer fristPage) {
		this.fristPage = fristPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getRangeMin() {
		return rangeMin;
	}

	public void setRangeMin(Integer rangeMin) {
		this.rangeMin = rangeMin;
	}

	public Integer getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(Integer rangeMax) {
		this.rangeMax = rangeMax;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	@Override
	public String toString() {
		return "Pagination [id=" + id + ", fristPage=" + fristPage + ", currentPage=" + currentPage + ", rangeMin="
				+ rangeMin + ", rangeMax=" + rangeMax + ", lastPage=" + lastPage + "]";
	}

	 
    

     

}

package com.multiplicatalent.colors.api.util;

import com.multiplicatalent.colors.api.models.api.request.PageRequest;
import com.multiplicatalent.colors.api.models.api.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Objects;

/**
 * Class <b>PageUtil</b>.
 * @author Giancarlo
 */
public class PageUtil {

  public PageUtil() {
    super();
  }

  /**
   * Method for convert page to pageResponse
   * @param page Page.
   * @return
   */
  public static PageResponse pageToPageResponse(Page page) {
    return PageResponse.builder()
            .colors(page.getContent())
            .totalElements(page.getTotalElements())
            .totalPages(page.getTotalPages())
            .first(page.isFirst())
            .last(page.isLast())
            .build();
  }

  /**
   * Convert PageRequest to Pageable.
   * @param pageRequest Parameters to Pageable (page, size).
   * @return Pageable.
   */
  public static Pageable getPageable(PageRequest pageRequest) {
    Integer page = pageRequest.getPage();
    Integer size = pageRequest.getSize();

    Integer localPage = Objects.isNull(page) ? Constants.DEFAULT_PAGE : page - 1;
    Integer localSize = Objects.isNull(size) ? Constants.DEFAULT_SIZE : size;

    return org.springframework.data.domain.PageRequest.of(localPage, localSize);
  }


}

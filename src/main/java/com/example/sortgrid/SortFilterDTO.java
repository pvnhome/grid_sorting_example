package com.example.sortgrid;

/**
 * <p><b>Created:</b> 16.04.2019 23:34:46</p>
 * @author victor
 */
public class SortFilterDTO {
   private final boolean needFilter;

   public SortFilterDTO() {
      this(true);
   }

   public SortFilterDTO(boolean needFilter) {
      this.needFilter = needFilter;
   }

   @Override
   public String toString() {
      return needFilter ? "[need to filter]" : "[not need to filter]";
   }

   public boolean isNeedFilter() {
      return needFilter;
   }
}

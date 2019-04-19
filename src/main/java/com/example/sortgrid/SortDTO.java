package com.example.sortgrid;

/**
 * <p><b>Created:</b> 16.04.2019 23:20:20</p>
 * @author victor
 */
public class SortDTO {
   private Integer id;
   private String a;
   private String b;
   private String c;

   public SortDTO(Integer id, String a, String b, String c) {
      this.id = id;
      this.a = a;
      this.b = b;
      this.c = c;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getA() {
      return a;
   }

   public void setA(String a) {
      this.a = a;
   }

   public String getB() {
      return b;
   }

   public void setB(String b) {
      this.b = b;
   }

   public String getC() {
      return c;
   }

   public void setC(String c) {
      this.c = c;
   }
}

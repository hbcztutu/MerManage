package test;

import java.io.Serializable;

public class Person implements Serializable {
/**
   * 
   */
  private static final long serialVersionUID = 1L;
private int id;
private String name;
 
public Person(int id, String name) {
this.id = id;
this.name = name;
}
 
public Person() {
  // TODO Auto-generated constructor stub
}

public int getId() {
return id;
}
 
public String getName() {
return name;
}

public void setId(int id) {
  this.id = id;
}

public void setName(String name) {
  this.name = name;
}

}
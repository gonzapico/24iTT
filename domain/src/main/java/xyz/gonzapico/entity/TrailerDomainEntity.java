package xyz.gonzapico.entity;

/**
 * Created by gfernandez on 28/02/17.
 */

public class TrailerDomainEntity {

  String key = "";
  String name = "";
  String type = "";
  int size;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}

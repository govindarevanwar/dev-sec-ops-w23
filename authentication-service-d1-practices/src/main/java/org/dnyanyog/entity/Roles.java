package org.dnyanyog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Roles {

  public static Roles getInstance() {
    return new Roles();
  }

  @Id @GeneratedValue @Column private long roleId;

  @Column private String roleName;

  public long getRoleId() {
    return roleId;
  }

  public Roles setRoleId(long roleId) {
    this.roleId = roleId;
    return this;
  }

  public String getRoleName() {
    return roleName;
  }

  public Roles setRoleName(String roleName) {
    this.roleName = roleName;

    return this;
  }
}

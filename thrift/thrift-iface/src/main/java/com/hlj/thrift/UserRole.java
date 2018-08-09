package com.hlj.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("UserRole")
public final class UserRole
{
    public UserRole() {
    }

    private long id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.REQUIRED)
    public long getId() { return id; }

    @ThriftField
    public void setId(final long id) { this.id = id; }

    private long userId;

    @ThriftField(value=2, name="userId", requiredness=Requiredness.REQUIRED)
    public long getUserId() { return userId; }

    @ThriftField
    public void setUserId(final long userId) { this.userId = userId; }

    private long roleId;

    @ThriftField(value=3, name="roleId", requiredness=Requiredness.REQUIRED)
    public long getRoleId() { return roleId; }

    @ThriftField
    public void setRoleId(final long roleId) { this.roleId = roleId; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("userId", userId)
            .add("roleId", roleId)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserRole other = (UserRole)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(userId, other.userId) &&
            Objects.equals(roleId, other.roleId);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            userId,
            roleId
        });
    }
}

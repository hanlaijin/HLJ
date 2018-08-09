package com.hlj.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("RoleFunction")
public final class RoleFunction
{
    public RoleFunction() {
    }

    private long id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.REQUIRED)
    public long getId() { return id; }

    @ThriftField
    public void setId(final long id) { this.id = id; }

    private long roleId;

    @ThriftField(value=2, name="roleId", requiredness=Requiredness.REQUIRED)
    public long getRoleId() { return roleId; }

    @ThriftField
    public void setRoleId(final long roleId) { this.roleId = roleId; }

    private long functionId;

    @ThriftField(value=3, name="functionId", requiredness=Requiredness.REQUIRED)
    public long getFunctionId() { return functionId; }

    @ThriftField
    public void setFunctionId(final long functionId) { this.functionId = functionId; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("roleId", roleId)
            .add("functionId", functionId)
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

        RoleFunction other = (RoleFunction)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(roleId, other.roleId) &&
            Objects.equals(functionId, other.functionId);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            roleId,
            functionId
        });
    }
}

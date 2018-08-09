package com.hlj.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("Role")
public final class Role
{
    public Role() {
    }

    private long id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.REQUIRED)
    public long getId() { return id; }

    @ThriftField
    public void setId(final long id) { this.id = id; }

    private String name;

    @ThriftField(value=2, name="name", requiredness=Requiredness.REQUIRED)
    public String getName() { return name; }

    @ThriftField
    public void setName(final String name) { this.name = name; }

    private int status;

    @ThriftField(value=3, name="status", requiredness=Requiredness.REQUIRED)
    public int getStatus() { return status; }

    @ThriftField
    public void setStatus(final int status) { this.status = status; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("name", name)
            .add("status", status)
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

        Role other = (Role)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(name, other.name) &&
            Objects.equals(status, other.status);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            name,
            status
        });
    }
}

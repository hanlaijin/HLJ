package com.hlj.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("Function")
public final class Function
{
    public Function() {
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

    private String url;

    @ThriftField(value=4, name="url", requiredness=Requiredness.REQUIRED)
    public String getUrl() { return url; }

    @ThriftField
    public void setUrl(final String url) { this.url = url; }

    private long parentId;

    @ThriftField(value=5, name="parentId", requiredness=Requiredness.REQUIRED)
    public long getParentId() { return parentId; }

    @ThriftField
    public void setParentId(final long parentId) { this.parentId = parentId; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("name", name)
            .add("status", status)
            .add("url", url)
            .add("parentId", parentId)
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

        Function other = (Function)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(name, other.name) &&
            Objects.equals(status, other.status) &&
            Objects.equals(url, other.url) &&
            Objects.equals(parentId, other.parentId);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            name,
            status,
            url,
            parentId
        });
    }
}

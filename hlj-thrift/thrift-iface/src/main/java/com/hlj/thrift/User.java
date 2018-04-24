package com.hlj.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("User")
public final class User
{
    public User() {
    }

    private long id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.REQUIRED)
    public long getId() { return id; }

    @ThriftField
    public void setId(final long id) { this.id = id; }

    private String mobile;

    @ThriftField(value=2, name="mobile", requiredness=Requiredness.REQUIRED)
    public String getMobile() { return mobile; }

    @ThriftField
    public void setMobile(final String mobile) { this.mobile = mobile; }

    private String password;

    @ThriftField(value=3, name="password", requiredness=Requiredness.REQUIRED)
    public String getPassword() { return password; }

    @ThriftField
    public void setPassword(final String password) { this.password = password; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("mobile", mobile)
            .add("password", password)
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

        User other = (User)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(mobile, other.mobile) &&
            Objects.equals(password, other.password);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            mobile,
            password
        });
    }
}

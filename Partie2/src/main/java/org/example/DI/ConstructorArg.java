package org.example.DI;

import javax.xml.bind.annotation.XmlAttribute;

public class ConstructorArg {
    private String name;
    private String ref;

    @XmlAttribute
    public String getId() {
        return name;
    }

    public void setId(String id) {
        this.name = id;
    }

    @XmlAttribute
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}

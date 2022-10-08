package org.edwith.webbe.guestbook.dto;

import java.util.Date;

public class Guestbook {
    private Long nid;
    private String name;
    private String content;
    private Date regdate;

    public Guestbook(Long nid, String name, String content, Date regdate) {
        this.nid = nid;
        this.name = name;
        this.content = content;
        this.regdate = regdate;
    }

    public Guestbook(String name, String content) {
        this.name = name;
        this.content = content;
        this.regdate = new Date();
    }
    
    public Guestbook() {
        this.regdate = new Date();
    }
    
    public long getnid() {
        return nid;
    }

    public void setnid(long nid) {
        this.nid = nid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "Guestbook{" +
                "nid=" + nid +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}

package com.rcview.syh.yongheshen.recyclerviewdemo;

/**
 * 作者： yongheshen on 15/11/23.
 * 描述：
 */
public class ItemData
{
    private String title;
    private String content;

    public ItemData(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public String getTitle()
    {
        return title;
    }

    public String getContent()
    {
        return content;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}

package model;

public class Reader {


    private Integer readerId;
    private String readerName;

    public Reader(String readerName, int id) {
        this.readerId = id;
        this.readerName = readerName;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }



    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", readerName='" + readerName + '\'' +
                '}';
    }
}

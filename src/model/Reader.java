package model;

public class Reader {

    private static int nextId = 1;
    private Integer readerId;
    private String readerName;

    public Reader(String readerName) {
        this.readerId = nextId++;
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

package salon.api.dto;

public class UploadResponseDto {

    private String name;
    private String url;
    private String fileType;
    private long size;


    public UploadResponseDto(String name, String url, String fileType, long size) {
        this.name = name;
        this.url = url;
        this.fileType = fileType;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}

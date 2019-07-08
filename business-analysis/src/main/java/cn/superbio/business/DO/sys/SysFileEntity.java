package cn.superbio.business.DO.sys;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("file_entity")
public class SysFileEntity {
    private String fileId; //�ļ�id
    private String fileMd5; //'�ļ�md5
    private String filePath; //�ļ�·��
    private String fileType; //�ļ���������
    private String fileExtension; //�ļ���׺��չ��
    private double fileSize; //�ļ���С(��λB)

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }
}

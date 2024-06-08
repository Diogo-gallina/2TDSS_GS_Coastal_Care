package com.coastalcare.utils;

import com.coastalcare.infra.exceptions.FailAwsConnectException;
import com.coastalcare.infra.exceptions.FailUploadedImageToS3Exception;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

public class S3ImageUploader {
    private static final Dotenv dotenv = Dotenv.load();
    private static final Region REGION = Region.US_EAST_1;
    private static final String BUCKET_NAME = dotenv.get("BUCKET_NAME");
    private static final String ACCESS_KEY_ID = dotenv.get("ACCESS_KEY_ID");
    private static final String SECRET_ACCESS_KEY = dotenv.get("SECRET_ACCESS_KEY");



    public static String uploadImageToS3(MultipartFile file) {
        S3Client s3Client = connectS3();
//        checkFileIsImage(file);
        try {
            PutObjectResponse response = s3Client.putObject(PutObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(file.getOriginalFilename())
                    .build(), RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
            return "https://" + BUCKET_NAME + ".s3." + REGION.id() + ".amazonaws.com/" + file.getOriginalFilename();
        } catch (Exception e) {
            s3Client.close();
            throw new FailUploadedImageToS3Exception("Erro ao fazer upload da imagem para o Amazon S3: " + e.getMessage());
        }
    }

    private static S3Client connectS3() {
        try {
            return S3Client.builder()
                    .region(REGION)
                    .credentialsProvider(
                            StaticCredentialsProvider.create(AwsBasicCredentials.create(ACCESS_KEY_ID, SECRET_ACCESS_KEY)))
                    .build();
        } catch (Exception e) {
            throw new FailAwsConnectException("Erro ao tentar se conectar com a AWS: " + e.getMessage());
        }
    }

}

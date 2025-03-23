package ch.c0de.skill.spring6webapp.services;

import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.model.ListObjects;
import com.oracle.bmc.objectstorage.requests.ListObjectsRequest;
import com.oracle.bmc.objectstorage.responses.ListObjectsResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectStorageService {
    private ObjectStorageClient objectStorageClient;

    private final String namespaceName = "idh7rrec997p"; // You can get this via console or API
    private final String bucketName = "bucket001";
    private final String region = "us-ashburn-1";

    @PostConstruct
    public void init() throws Exception {
        var provider = new ConfigFileAuthenticationDetailsProvider("~/.oci/config", "DEFAULT");
        objectStorageClient = new ObjectStorageClient(provider);
        objectStorageClient.setRegion(region);
    }

    public List<String> listObjects() {
        ListObjectsRequest request = ListObjectsRequest.builder()
                .namespaceName(namespaceName)
                .bucketName(bucketName)
                .build();

        ListObjectsResponse response = objectStorageClient.listObjects(request);
        ListObjects objects = response.getListObjects();

        return objects.getObjects()
                .stream()
                .map(obj -> obj.getName())
                .collect(Collectors.toList());
    }
}

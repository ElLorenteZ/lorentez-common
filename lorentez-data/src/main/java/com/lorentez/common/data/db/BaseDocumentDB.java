package com.lorentez.common.data.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseDocumentDB {
    @Id
    private UUID id;

    @Version
    private Long version;

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    protected ZonedDateTime creationTimestamp;

    @LastModifiedBy
    protected String lastModifiedBy;

    @LastModifiedDate
    protected ZonedDateTime lastModificationTimestamp;
}

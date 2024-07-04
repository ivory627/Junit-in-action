package com.study.junit.ch06.bad;

public class Document {
    private DocumentType documentType;

    public Document(DocumentType documentType) {
        this.documentType = documentType;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }
}
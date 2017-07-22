package org.avlasov.springexamples.beanqualifying.entity;

/**
 * Created by artemvlasov on 20/07/2017.
 */
public class QualifierEntity {

    private QualifiedEntity qualifiedEntity;

    public QualifierEntity(QualifiedEntity qualifiedEntity) {
        this.qualifiedEntity = qualifiedEntity;
    }

    public QualifiedEntity getQualifiedEntity() {
        return qualifiedEntity;
    }

    public void setQualifiedEntity(QualifiedEntity qualifiedEntity) {
        this.qualifiedEntity = qualifiedEntity;
    }
}

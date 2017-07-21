package org.avlasov.springexamples.beanqualifying.entity;

import org.avlasov.springexamples.entity.MainEntityBean;

/**
 * Created by artemvlasov on 20/07/2017.
 */
public class QualifierEntity extends MainEntityBean {

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

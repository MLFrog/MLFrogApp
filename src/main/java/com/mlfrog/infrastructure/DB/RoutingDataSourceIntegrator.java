package com.mlfrog.infrastructure.DB;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * 테스트 코드 때문에 구현한 클래스이나, 사용하지 않을 것으로 보여 deprecated
 * @author user
 *
 */
@Deprecated
public class RoutingDataSourceIntegrator implements Integrator {

	private final DataSource dataSource;

    public RoutingDataSourceIntegrator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void integrate(Metadata metadata, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
        try {
			((RoutingDataSource) dataSource).setDefaultTargetDataSource(sessionFactory.getJdbcServices().getBootstrapJdbcConnectionAccess().obtainConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
        // Do nothing
    }

}

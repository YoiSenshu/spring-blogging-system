package pl.yoisenshu.springbloggingsystem.model.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlReportRepository<T extends Report> extends ReportRepository<T>, JpaRepository<T, Integer> { }

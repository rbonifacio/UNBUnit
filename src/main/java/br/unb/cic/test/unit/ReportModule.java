package br.unb.cic.test.unit;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ReportModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Report> reportMultibinder = Multibinder.newSetBinder(binder(), Report.class);



        reportMultibinder.addBinding().to(DefaultReport.class);
        reportMultibinder.addBinding().to(JsonReportGenerator.class);
        // new reports here
    }
}

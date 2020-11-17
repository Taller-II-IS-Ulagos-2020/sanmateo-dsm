package cl.ulagos.reporte;

import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.report.DefaultAdhocReportCustomizer;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.exception.DRException;

public class ReportCustomizer extends DefaultAdhocReportCustomizer {

	@Override
	public void customize(ReportBuilder<?> report, AdhocReport adhocReport) throws DRException {

		super.customize(report, adhocReport);
		// default report values
		report.setTemplate(Templates.reportTemplate);
		report.title(Templates.createTitleComponent("Total de Ventas"));

		// a fixed page footer that user cannot change, this customization is not stored in the xml file
		report.pageFooter(Templates.footerComponent);

	}

	@Override
	protected DRIDataType<?, ?> getFieldType(String name) {

		if (name.equals("Cliente")) 
			return type.stringType();

		if (name.equals("Producto")) 
			return type.stringType();

		if (name.equals("PrecioUnitario")) 
			return type.integerType();

		return super.getFieldType(name);

	}

	@Override
	protected String getFieldLabel(String name) {

		if (name.equals("Cliente")) 
			return "Cliente";

		if (name.equals("Producto")) 
			return "Producto";

		if (name.equals("PrecioUnitario")) 
			return "Precio Unitario";

		return name;
	}
}
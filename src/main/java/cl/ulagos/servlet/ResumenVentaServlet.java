package cl.ulagos.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ulagos.dao.DAOCliente;
import cl.ulagos.modelo.Cliente;
import cl.ulagos.modelo.Producto;
import cl.ulagos.reporte.ReportCustomizer;
import net.sf.dynamicreports.adhoc.AdhocManager;
import net.sf.dynamicreports.adhoc.configuration.AdhocCalculation;
import net.sf.dynamicreports.adhoc.configuration.AdhocColumn;
import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.configuration.AdhocGroup;
import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.configuration.AdhocSort;
import net.sf.dynamicreports.adhoc.configuration.AdhocSubtotal;
import net.sf.dynamicreports.adhoc.transformation.AdhocToXmlTransform;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransform;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;


@WebServlet(name="ResumenVenta", urlPatterns = {"/controlador/ResumenVenta"})
public class ResumenVentaServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private DAOCliente daoCliente = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=VentasTotales.pdf");
		response.setHeader("Set-Cookie", "fileDownload=true; path=/");
		OutputStream out = response.getOutputStream();

		AdhocConfiguration configuration = new AdhocConfiguration();
		AdhocReport report = new AdhocReport();
		configuration.setReport(report);

		// columns
		AdhocColumn column = new AdhocColumn();
		column.setName("Producto");
		report.addColumn(column);
		column = new AdhocColumn();
		column.setName("PrecioUnitario");
		report.addColumn(column);

		// groups
		AdhocGroup group = new AdhocGroup();
		group.setName("Cliente");
		report.addGroup(group);

		// subtotal
		AdhocSubtotal subtotal = new AdhocSubtotal();
		subtotal.setCalculation(AdhocCalculation.SUM);
		subtotal.setName("PrecioUnitario");
		report.addSubtotal(subtotal);

		// sorts
		AdhocSort sort = new AdhocSort();
		sort.setName("Cliente");
		report.addSort(sort);

		try {

			AdhocManager adhocManager = AdhocManager.getInstance(new AdhocToXmlTransform(), new XmlToAdhocTransform());
			JasperReportBuilder reportBuilder = adhocManager.createReport(configuration.getReport(), new ReportCustomizer());
			reportBuilder.setDataSource(createDataSource());
			reportBuilder.toPdf(out);

		} catch (DRException e) {

			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() throws Exception {

		DRDataSource dataSource = new DRDataSource("Cliente", "Producto", "PrecioUnitario");
		try{
			InitialContext ctx = new InitialContext();
			daoCliente = (DAOCliente) ctx.lookup("java:app/sanmateo/DAOClienteImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}
		
		List<Cliente> listaCliente = daoCliente.listar();
		for (Cliente c : listaCliente)
		{
			List<Producto> listaProducto = c.getProductos();
			for (Producto p: listaProducto) {
				dataSource.add(c.getNombre(), p.getNombre(), (int) p.getPrecio());
			}
		}
		return dataSource;
	}
}



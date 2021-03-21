package com.mtanuri.pdfbuilder.rest;

import com.mtanuri.pdfbuilder.Report;
import com.mtanuri.pdfbuilder.exception.InvalidReportNameException;
import com.mtanuri.pdfbuilder.factory.ReportFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.util.*;

@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/pdf-builder",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=PDFBuilder.Rest"
        },
        service = Application.class
)
public class PDFBuilderApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @GET
    @Path("/{reportName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response build(@Context HttpServletRequest request, @PathParam("reportName") String reportName) {

        Map<String, String> params = new HashMap<>();
        ByteArrayOutputStream outputStream = null;
        try {
            Report report = ReportFactoryUtil.create(reportName);
            outputStream = (ByteArrayOutputStream) report.print(params);
        } catch (InvalidReportNameException e) {
            _log.error(e);
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        catch (Exception e) {
            _log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        String base64 = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        return Response.status(Response.Status.OK).entity(base64).build();
    }

    private static final Log _log = LogFactoryUtil.getLog(PDFBuilderApplication.class);

}

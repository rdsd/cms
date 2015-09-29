package com.cms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.cms.bo.CourseBO;
import com.cms.exceptions.CMSBusinessException;
import com.cms.exceptions.CMSException;
import com.cms.vo.CourseVO;

/**
 * Servlet implementation class RetrieveCourseController
 */
@WebServlet("/RetrieveCourseController")
public class RetrieveCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger
			.getLogger(RetrieveCourseController.class);

	public RetrieveCourseController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("In RetrieveCourseController.doPost Method");
		LOG.info("In AddCourseController.doPost Method");
		CourseVO courseVO = new CourseVO();
		CourseBO courseBO = new CourseBO();
		boolean courseExistenceFlag = false;
		RequestDispatcher dispatcher = null;
		String courseCode = request.getParameter("courseCode");

		try {
			courseExistenceFlag = courseBO.checkCourseCodeExistence(courseCode);

			if (courseExistenceFlag) {
				courseVO = courseBO.getCourseDetails(courseCode);
				request.setAttribute("courseCode", courseVO.getCourseCode());
				request.setAttribute("courseName", courseVO.getCourseName());
				request.setAttribute("courseDescription",
						courseVO.getCourseDescription());
				request.setAttribute("noOfParticipants",
						courseVO.getNoOfParticipants());
				request.setAttribute("courseType", courseVO.getCourseType());
				request.setAttribute("courseDuration",
						courseVO.getCourseDuration());
				request.setAttribute("courseFee", courseVO.getCourseFee());
				dispatcher = request
						.getRequestDispatcher("./courseDetails.jsp");
				dispatcher.forward(request, response);
			} else {
				throw new CMSBusinessException(
						"Course not found in the system! ");
			}
		} catch (CMSException e) {
			// e.printStackTrace();
			LOG.error("CMSException in RetreiveCourseController: ", e);
			String message = e.getMessage() + " Please try again!";
			dispatcher = request.getRequestDispatcher("./error.jsp");
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		} catch (CMSBusinessException e) {
			// e.printStackTrace();
			LOG.error("CMSBusinessException in RetreiveCourseController: ", e);
			String message = e.getMessage() + " Please try again!";
			dispatcher = request.getRequestDispatcher("./retrieveCourse.jsp");
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		}

	}
}

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
import com.cms.constants.ErrorConstants;
import com.cms.exceptions.CMSBusinessException;
import com.cms.exceptions.CMSException;
import com.cms.vo.CourseVO;

/**
 * Servlet implementation class AddCourseController
 */
@WebServlet("/AddCourseController")
public class AddCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/** The Constant LOG. */
	private static final Logger LOG = Logger
			.getLogger(AddCourseController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCourseController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("In AddCourseController.doPost Method");
		LOG.info("In AddCourseController.doPost Method");
		RequestDispatcher dispatcher = null;
		CourseVO courseVO = null;
		try {
			try {
				String courseCode = request.getParameter("courseCode");
				String courseName = request.getParameter("courseName");
				String courseDescription = request
						.getParameter("courseDescription");
				int noOfParticipants = Integer.parseInt(request
						.getParameter("noOfParticipants"));
				String courseDuration = request.getParameter("courseDuration");
				String courseType = request.getParameter("courseType");

				courseVO = new CourseVO();
				courseVO.setCourseCode(courseCode);
				courseVO.setCourseName(courseName);
				courseVO.setCourseDescription(courseDescription);
				courseVO.setNoOfParticipants(noOfParticipants);
				courseVO.setCourseDuration(courseDuration);
				courseVO.setCourseType(courseType);
			} catch (NumberFormatException e) {
				// e.printStackTrace();
				LOG.error("NumberFormatException in AddCourseController: ", e);
				throw new CMSBusinessException(
						ErrorConstants.DATA_FORMAT_EXCEPTION);
			}

			CourseBO courseBO = new CourseBO();
			boolean courseAddedFlag;
			courseAddedFlag = courseBO.addCourse(courseVO);

			if (courseAddedFlag) {
				dispatcher = request.getRequestDispatcher("./courseAdded.jsp");
				dispatcher.forward(request, response);
			}
		} catch (CMSBusinessException e) {
			// e.printStackTrace();
			LOG.error("Exception Caught In AddCourseController:", e);
			String message = e.getMessage() + " Please try again!";
			dispatcher = request.getRequestDispatcher("./addCourse.jsp");
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		} catch (CMSException e) {
			// e.printStackTrace();
			LOG.error("CMSException in AddCourseController: ", e);
			String message = e.getMessage() + " Please try again!";
			dispatcher = request.getRequestDispatcher("./error.jsp");
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		}

	}
}

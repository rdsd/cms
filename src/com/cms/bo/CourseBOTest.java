package com.cms.bo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cms.exceptions.CMSBusinessException;
import com.cms.exceptions.CMSException;
import com.cms.vo.CourseVO;

public class CourseBOTest {

	@Test
	public void test() {
		CourseBO courseBO = new CourseBO();
		CourseVO courseVO = new CourseVO();

		courseVO.setCourseCode("cms1");
		courseVO.setCourseName("database");
		courseVO.setCourseDescription("Learn about basin SQL statements");
		courseVO.setCourseType("Classroom");
		courseVO.setCourseDuration("D1");
		courseVO.setNoOfParticipants(20);

		try {
			boolean courseAdded = courseBO.addCourse(courseVO);

			assertEquals(courseAdded, false);

		} catch (CMSBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

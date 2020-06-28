package com.fh.springcore;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;

import com.fh.dto.AnnotatedClass;

public class TestAnnotationMetadata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationMetadata am = new StandardAnnotationMetadata(AnnotatedClass.class);
		for(String name : am.getMemberClassNames()){
			System.out.println("Member class name: "+name);
		}
		
		/**
		 * Tested, it only find the annotation at class level, not method level
		 */
		for(String type : am.getAnnotationTypes()){
			System.out.println("Annotation type: "+type);
		}
	}

}

package com.algo.top50.stringandarray;

import java.util.HashSet;
import java.util.Set;

public class UniqueEamilAddress_11 {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
        System.out.println(numUniqueEmails_split(emails));
    }

    static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String localName = getLocalName2(email);
            String domainName = getDomainName(email);
            uniqueEmails.add(localName + "@" + domainName);
        }
        return uniqueEmails.size();
    }

	private static String getLocalName(String email) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '.') {
				continue;
			}
			if (email.charAt(i) == '+') {
				break;
			}
			if (email.charAt(i) == '@') {
				break;
			}
			String str = String.valueOf(email.charAt(i));
			sb.append(str);

		}
		return sb.toString();
	}

    private static String getLocalName2(String email) {
    	String result = email.split("@")[0];

        result = result.replaceAll(".", "");

        if (result.indexOf("+") > 0) {
            result = result.substring(0, result.indexOf("+"));
        }

        return result;
    }

    private static String getDomainName(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

    public static int numUniqueEmails_split(String[] emails) {
        Set<String> sentEmails = new HashSet();
        if (emails == null) {
            return 0;
        }

        for (String email : emails) {
            String[] parts = email.split("\\@");
            String[] partsForPlus = parts[0].split("\\+");
            String[] partsForDot = partsForPlus[0].split("\\.");
            StringBuilder emailM = new StringBuilder();
            for (String part : partsForDot) {
                emailM.append(part);
            }
            emailM.append("@" + parts[1]);
            sentEmails.add(emailM.toString());
        }
        return sentEmails.size();
    }


}

package fr.eni.gamemanager.dal;

import fr.eni.gamemanager.bo.ForgetPassword;

public interface ForgetPasswordDao extends DAO<ForgetPassword> {
	ForgetPassword resetPassword(String email );
}

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Email Perdido

def encontra_email_perdido(emails_enviados, emails_recebidos):
	for emaile in emails_enviados:
		n = 0
		for email in emails_recebidos:
			if emaile == email:
				break
			else:
				n += 1
				
		if n == len(emails_recebidos):
			return emaile

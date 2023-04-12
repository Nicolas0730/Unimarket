package co.edu.uniquindio.proyecto.servicios.implementacion;

import org.springframework.stereotype.Service;

public class EmailServicioImpl {
    @Service
    public class EmailServicio {}
//metodo de email en priyecto avanzada de burgos
//        private final JavaMailSender javaMailSender;
//
//        public EmailServicio(JavaMailSender javaMailSender) {
//            this.javaMailSender = javaMailSender;
//        }
//
//        public void enviarEmail(String asunto, String contenido, String destinatario) {
//
//            MimeMessage mensaje = javaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mensaje);
//
//            try {
//                helper.setSubject(asunto);
//                helper.setText(contenido, true);
//                helper.setTo(destinatario);
//                helper.setFrom("clientes.unimarket@gmail.com");
//
//                javaMailSender.send(mensaje);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//
}

package gr.aueb.cf.schoolapp.api;

//@Path("/teachers")
//public class TeacherResource {
//
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getTeacher(@PathParam("id") Long id) {  // Capture path parameter
//
////        TeacherReadOnlyDTO dto = TeacherReadOnlyDTO.builder()
////                .id(id)
////                .ssn("123456")
////                .firstname("Αθανάσιος")
////                .lastname("Ανδρούτσος")
////                .build();
//        TeacherReadOnlyDTO dto= new TeacherReadOnlyDTO(id, "123456", "Αθανάσιος",
//                "Ανδρούτσος");
//
//
//        return Response.ok(dto).build();
////        return Response   // for non-200 statuses
////                .status(Response.Status.OK)
////                .entity(dto)
////                .build();
//    }
//
//}

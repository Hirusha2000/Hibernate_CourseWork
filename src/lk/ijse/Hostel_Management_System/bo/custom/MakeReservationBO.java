package lk.ijse.Hostel_Management_System.bo.custom;

import lk.ijse.Hostel_Management_System.bo.SuperBO;
import lk.ijse.Hostel_Management_System.dto.ReservationDTO;
import lk.ijse.Hostel_Management_System.dto.RoomDTO;
import lk.ijse.Hostel_Management_System.dto.StudentDTO;

import java.util.List;

public interface MakeReservationBO extends SuperBO {
    List<StudentDTO> getAllStudents();

    List<RoomDTO> getAllRooms();

    String generateNewReservationID();

    boolean saveStudent(StudentDTO studentDTO);

    boolean checkTheStudentIsExist(String studentId);

    boolean saveReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> getAllReservations();

    boolean updateRoomDetails(RoomDTO roomDTO);
}

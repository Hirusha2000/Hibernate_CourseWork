package lk.ijse.Hostel_Management_System.bo.custom.impl;

import lk.ijse.Hostel_Management_System.bo.custom.ReservationDetailsBO;
import lk.ijse.Hostel_Management_System.dao.DAOFactory;
import lk.ijse.Hostel_Management_System.dao.SuperDAO;
import lk.ijse.Hostel_Management_System.dao.custom.ReservationDAO;
import lk.ijse.Hostel_Management_System.dao.custom.RoomDAO;
import lk.ijse.Hostel_Management_System.dao.custom.StudentDAO;
import lk.ijse.Hostel_Management_System.dto.ReservationDTO;
import lk.ijse.Hostel_Management_System.dto.RoomDTO;
import lk.ijse.Hostel_Management_System.dto.StudentDTO;
import lk.ijse.Hostel_Management_System.entity.Reservation;
import lk.ijse.Hostel_Management_System.entity.Room;
import lk.ijse.Hostel_Management_System.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ReservationDetailsBOImpl implements ReservationDetailsBO {

    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> all = reservationDAO.getAll();
        List<ReservationDTO> allReservations=new ArrayList<>();
        for (Reservation reservation : all) {
            allReservations.add(new ReservationDTO(reservation.getRes_id(),reservation.getDate(),reservation.getStatus(),reservation.getStudent(),reservation.getRoom()));
        }
        return allReservations;
    }

    @Override
    public boolean removeReservation(String id) {
        return reservationDAO.delete(id);
    }

    @Override
    public boolean updateRoomQty(String roomTypeID, int qty) {
        return roomDAO.updateQty(roomTypeID,qty);
    }

    @Override
    public RoomDTO getRoom(String roomTypeID) {
        Room room = roomDAO.search(roomTypeID);
        return new RoomDTO(room.getRoomTypeId(),room.getType(),room.getKeyMoney(),room.getQty());
    }

    @Override
    public boolean updateReservationStatus(String res_id, String status) {
        return reservationDAO.updateStatus(res_id,status);
    }

    @Override
    public StudentDTO getStudent(String studentID) {
        Student student = studentDAO.search(studentID);
        return new StudentDTO(student.getStudentId(),student.getName(),student.getAddress(),student.getContactNo(),student.getDob(),student.getGender());
    }
}

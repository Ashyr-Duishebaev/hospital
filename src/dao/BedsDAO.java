package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Beds;

public interface BedsDAO {
	@Insert("INSERT INTO beds (bed_type, is_occupied) VALUES (#{bedType}, #{occupied})")
	void createBed(Beds bed);

	@Select("SELECT * FROM beds WHERE bed_id = #{id}")
	Beds getBedById(int id);

	@Select("SELECT * FROM beds")
	List<Beds> getAllBeds();

	@Update("UPDATE beds SET bed_type = #{bedType}, is_occupied = #{occupied} WHERE bed_id = #{bedId}")
	void updateBed(Beds bed);

	@Delete("DELETE FROM beds WHERE bed_id = #{bedId}")
	void deleteBed(Beds bed);
}

package com.cglia.bms.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cglia.bms.dao.BookDAO;
import com.cglia.bms.db.util.DataBaseUtil;
import com.cglia.bms.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	@Override
	public Integer save(Book book) {
	    final String query = "INSERT INTO books (title,author,price) values (?,?,?)";
	    Integer id=0;
	    try (
	        Connection con = DataBaseUtil.getConnection();
	        PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	    ) {
	        ps.setString(1, book.getTitle());
	        ps.setString(2, book.getAuthor());
	        ps.setDouble(3, book.getPrice());
	        int count = ps.executeUpdate();
	        if (count != 0) {
	            try (ResultSet rs = ps.getGeneratedKeys()) {
	                if (rs.next()) {
	                    id = rs.getInt(1);
	                    System.out.println("Book saved with id=" + id);
	                }
	            }
	        } else {
	        	
	            System.out.println("Book save failed");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return id;
	}


	public Book getById(Integer id) {
		final String query="SELECT * FROM books WHERE id = ?";
		Book book=null;
		try(Connection con=DataBaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1, id);
			try(ResultSet rs=stmt.executeQuery()){
				if(rs.next()) {
					book=new Book();
					book.setId(rs.getInt("id"));
					book.setTitle(rs.getString("title"));
					book.setAuthor(rs.getString("author"));
					book.setPrice(rs.getDouble("price"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public int update(Book book) {
		final String query="UPDATE books SET title = ?,  author = ?,price = ? WHERE id = ?";
		int count=0;
		try(Connection con=DataBaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setDouble(3, book.getPrice());
			stmt.setInt(4, book.getId());
			count=stmt.executeUpdate();
			if(count!=0) {
				System.out.println("Book with ID:"+book.getId()+" is updated");
			}else {
				System.out.println("update failed.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteById(Integer id) {
		final String query="DELETE FROM books WHERE id=?";
		int count=0;
		try(Connection con=DataBaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query);	){
			stmt.setInt(1, id);
			count=stmt.executeUpdate();
			
			if(count!=0) {
				System.out.println("Book with ID:"+id+" is deleted");
			}else {
				System.out.println("Deletion failed.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public List<Book> getAll() {
		final String query="SELECT * FROM books";
		List<Book> bookList=new ArrayList<>();
		
		try(Connection con=DataBaseUtil.getConnection();
			Statement stmt=con.createStatement();	){
			boolean areAnyRecords=stmt.execute(query);
			if(areAnyRecords) {
				try(ResultSet rs=stmt.getResultSet()){
					if(rs!=null) {
						while(rs.next()) {
							Book book=new Book();
							book.setId(rs.getInt("ID"));
							book.setTitle(rs.getString(2));
							book.setAuthor(rs.getString(3));
							book.setPrice(rs.getDouble(4));
							bookList.add(book);
						}
					}
				}
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}

}

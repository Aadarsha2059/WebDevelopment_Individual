package org.example.individual.Controller;


import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Sellbooks;
import org.example.individual.Pojo.GlobalAPIResponse;
import org.example.individual.Pojo.SellBooksPojo;
import org.example.individual.Pojo.SellBooksProjection;
import org.example.individual.Service.SellBookService;
import org.example.individual.util.ImageToBase64;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("sellbook")
@RequiredArgsConstructor


public class SellBookController {
    private final SellBookService sellBookService;

    @GetMapping("sellbook/user/{userID}")
    public List<SellBookResponse> findAllData(){
        ImageToBase64 imageToBase64 = new ImageToBase64();
        List<SellBookResponse> bookResponseList =new ArrayList<>();
        List<SellBooksProjection> items= this.sellBookService.findAllProj();
        items.forEach(item->{
            SellBookResponse bookResponse = new SellBookResponse();

            bookResponse.setId(item.getId());
            bookResponse.setSeeker(item.getSeekerId());
            bookResponse.setBookName(item.getBookName());
            bookResponse.setGenre(item.getGenre());
            bookResponse.setBookPrice(item.getBookPrice());
            bookResponse.setBookConditon(item.getBookCondition());
            bookResponse.setImage(imageToBase64.getImageBase64(item.getImage()));
            bookResponse.setUserId(item.getUserId());
            bookResponseList.add(bookResponse);




        });
        return bookResponseList;
    }

    @GetMapping
    public List<Sellbooks> findAll(){
        ImageToBase64 imageToBase64= new ImageToBase64();
        List<Sellbooks> items= this.sellBookService.findAll();
        items=items.stream().map(item ->{
            item.setImage(imageToBase64.getImageBase64(String.valueOf(item.getImage())));
            return item;
        }).collect(Collectors.toList());
        return items;


    }
    @GetMapping
    public List<Sellbooks> findByUserId(@PathVariable Integer id){
        ImageToBase64 imageToBase64= new ImageToBase64();
        List<Sellbooks> items=this.sellBookService.findByUserId(id);
        items =items.stream().map(item->{
            item.setImage(imageToBase64.getImageBase64(item.getImage()));
            return item;
        }).collect(Collectors.toList());
        return items;
    }
    @PostMapping
    public GlobalAPIResponse<Integer> save(@ModelAttribute SellBooksPojo sellBooksPojo) throws IOException{
        GlobalAPIResponse<Integer> globalAPIResponse = new GlobalAPIResponse<>();
        Integer bookId= sellBookService.save(sellBooksPojo);
        globalAPIResponse.setData(bookId);
        globalAPIResponse.setData(200);
        globalAPIResponse.setMessage("data saved successfully");
        return globalAPIResponse;
    }
    @PutMapping
    public void update(@RequestBody SellBooksPojo sellBooksPojo) throws IOException {
        GlobalAPIResponse<Integer> globalAPIResponse =new GlobalAPIResponse<>();
        sellBookService.save(sellBooksPojo);
        globalAPIResponse.setData(sellBooksPojo.getId());
        globalAPIResponse.setData(200);
        globalAPIResponse.setMessage("data updated successfully");
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id)  {
        GlobalAPIResponse<Integer> globalAPIResponse= new GlobalAPIResponse<>();
        sellBookService.deleteById(id);
        globalAPIResponse.setData(id);
        globalAPIResponse.setMessage("data deleted successfully");

    }

    @GetMapping
    public Sellbooks findById(@PathVariable Integer id){
        return this.sellBookService.findById(id);
    }



}

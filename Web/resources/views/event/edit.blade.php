@extends('layout.template')
<!-- START FORM -->
@section('konten') 


<form action='/event' method='post'>
@csrf 
<div class="my-3 p-3 bg-body rounded shadow-sm">
    <a href='{{ url('event') }}' class="btn btn-secondary"> kembali</a>
    <div class="mb-3 row">
        <label for="uraian" class="col-sm-2 col-form-label">Event id</label>
        <div class="col-sm-10">
             {{$data->eventid}}
        </div>
    </div> 
    <div class="mb-3 row">
        <label for="uraian" class="col-sm-2 col-form-label">Uraian</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name='uraian' value="{{$data->uraian}}" id="uraian">
        </div>
    </div> 
    <div class="mb-3 row">
        <label for="tujuan" class="col-sm-2 col-form-label">Tujuan</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name='tujuan' value="{{$data->tujuan}}" id="tujuan">
        </div>
    </div>
    <div class="mb-3 row">
        <label for="tanggal" class="col-sm-2 col-form-label">Tanggal</label>
        <div class="col-sm-10">
            <input type="date" class="form-control" name='tanggal' value="{{$data->tanggal}}" id="tanggal">
        </div>
    </div>
    <div class="mb-3 row">
        <label for="waktu" class="col-sm-2 col-form-label">Waktu</label>
        <div class="col-sm-10">
            <input type="time" class="form-control" name='waktu' value="{{$data->waktu}}" id="waktu">
        </div>
    </div>
    <div class="mb-3 row">
        <label for="submit" class="col-sm-2 col-form-label"></label>
        <div class="col-sm-10"><button type="submit" class="btn btn-primary" name="submit">SIMPAN</button></div>
    </div>
</div>
</form>
<!-- AKHIR FORM -->
@endsection
<?php

namespace App\Http\Controllers;

use App\Models\Event;
use App\Http\Requests\StoreEventRequest;
use App\Http\Requests\UpdateEventRequest;
use Illuminate\Support\Facades\Session;

class EventController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $data = event::orderBy('eventid','asc')->get();
        return view('event.index')->with('data',$data);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('event.create');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(StoreEventRequest $request)
    {
        Session::flash('uraian', $request->uraian);
        Session::flash('tujuan', $request->tujuan);
        Session::flash('tanggal', $request->tanggal);
        Session::flash('waktu', $request->waktu);
        $request->validate([
            'uraian'=>'required',
            'tujuan'=>'required',
            'tanggal'=>'required',
            'waktu'=>'required'
        ],[
            'uraian.required'=>'Uraian wanib diisi',
            'tujuan.required'=>'tujuan wajib diisi',
            'tanggal.required'=>'tanggal wajib diisi',
            'waktu.required'=>'waktu wajib diisi'
        ]);
        $data =  [
            'uraian' => $request -> uraian,
            'tujuan' => $request -> tujuan,
            'tanggal' => $request -> tanggal,
            'waktu' => $request -> waktu
        ];
        Event::create($data);
        return redirect('/event')->with('success','Success adding event');
    }

    /**
     * Display the specified resource.
     */
    public function show(Event $event)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Event $event)
    {
        $data = event::where('eventid',$event)->first();
        return view('event.id')->with('data', $data);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(UpdateEventRequest $request, Event $event)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Event $event)
    {
      
    }
}

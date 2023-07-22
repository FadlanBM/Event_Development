<?php

namespace App\Http\Controllers;

use App\Models\Event;
use App\Http\Requests\StoreEventRequest;
use App\Http\Requests\UpdateEventRequest;
use Illuminate\Http\Request;
use Inertia\Inertia;

class EventController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $message="Success";
        $id=auth()->user()->id;
        $event=Event::where('users_id',$id)->get();
        $data=[
            'name'=>$event,
            'kelas'=>'1'
        ];
        return Inertia::render('Event',['message'=>$message,'data'=>$data]);    
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $event=new Event();
        $event->name = $request->name;
        $event->uraian = $request->uraian;
        $event->users_id=auth()->user()->id;
        $event->tujuan = $request->tujuan;
        $event->tanggal = $request->tanggal;
        $event->waktu = $request->waktu;
        $event->save();
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
        //
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
        //
    }
}

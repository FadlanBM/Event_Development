<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Event;
use Illuminate\Auth\Events\Validated;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use Tests\Helper;

class EventsController extends Controller
{
    use Helper;
    public function create(Request $request){
        $validasi=Validator::make($request->all(),[
            'name'=>'required|unique:events',
            'uraian'=>'required',
            'tujuan'=>'required',
            'tanggal'=>'required',
            'waktu'=>'required',
            'users_id'=>'required'
        ]);

        if ($validasi->fails()) {
            return $this->error_400($validasi->errors()->first());
        }

        $events=Event::create($request->all());
        if ($events) {
        return $this->valid_200("Berhasil",$events);
        }else{
            return $this->error_400("Gagal");
        }
    }
}
